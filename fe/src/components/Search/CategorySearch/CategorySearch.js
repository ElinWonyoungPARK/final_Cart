import React, { useState } from 'react';
import moment from 'moment';
import { Button, Slider, Checkbox } from 'antd';
import ViewWithPopup from 'components/UI/ViewWithPopup/ViewWithPopup';
import InputIncDec from 'components/UI/InputIncDec/InputIncDec';
import { setStateToUrl, getStateFromUrl } from 'components/Search/url_handler';
import {
  priceInit,
  calenderItem,
  getAmenities,
  getPropertyType,
} from 'components/Search/SearchParams';
import CategroySearchWrapper, {
  RoomGuestWrapper,
  ItemWrapper,
  ActionWrapper,
} from 'components/Search/CategorySearch/CategorySearch.style';

const CategotySearch = ({ history, location }) => {
  const searchParams = getStateFromUrl(location);
  const state = {
    genre: searchParams.genre || [],
    hall: searchParams.hall || [],
    showing: searchParams.showing || {
      setStartDate: null,
      setEndDate: null,
    },
    finished: searchParams.finished || {
      min: 0,
      max: 100,
      defaultMin: 0,
      defaultMax: 100,
    },
    location: searchParams.location || {
      lat: null,
      lng: null,
    },
    room: parseInt(searchParams.room) || 0,
    guest: parseInt(searchParams.guest) || 0,
  };
  const { genre, hall, showing, finished, room, guest } = state;
  const [countRoom, setRoom] = useState(room);
  const [countGuest, setGuest] = useState(guest);

  const onChange = (value, type) => {
    const query = {
      ...state,
      [type]: value,
    };
    const search = setStateToUrl(query);
    history.push({
      pathname: '/listing',
      search: search,
    });
  };

  const handleRoomGuestApply = () => {
    const query = {
      ...state,
      room: countRoom,
      guest: countGuest,
    };
    const search = setStateToUrl(query);
    history.push({
      pathname: '/listing',
      search: search,
    });
  };

  const handleRoomGuestCancel = () => {
    setRoom(0);
    setGuest(0);
    const query = {
      ...state,
      room: 0,
      guest: 0,
    };
    const search = setStateToUrl(query);
    history.push({
      pathname: '/listing',
      search: search,
    });
  };

  const onSearchReset = () => {
    const search = setStateToUrl({ reset: '' });
    history.push({
      pathname: '/listing',
      search: search,
    });
  };

  return (
    <CategroySearchWrapper>
      <ViewWithPopup
        className={genre.length ? 'activated' : ''}
        key={getAmenities.id}
        noView={true}
        view={
          <Button type="default">
            {getAmenities.name}
            {genre.length > 0 && `: ${genre.length}`}
          </Button>
        }
        popup={
          <Checkbox.Group
            options={getAmenities.options}
            defaultValue={genre}
            onChange={(value) => onChange(value, 'genre')}
          />
        }
      />

      <ViewWithPopup
        className={hall.length ? 'activated' : ''}
        key={getPropertyType.id}
        noView={true}
        view={
          <Button type="default">
            {getPropertyType.name}
            {hall.length > 0 && `: ${hall.length}`}
          </Button>
        }
        popup={
          <Checkbox.Group
            options={getPropertyType.options}
            defaultValue={hall}
            onChange={(value) => onChange(value, 'hall')}
          />
        }
      />

      <ViewWithPopup
        className={
          Object.keys('showing').length !== null &&
          showing.setStartDate !== null
            ? 'activated'
            : ''
        }
        key={400}
        noView={true}
        view={<Button type="default">진행중인 전시</Button>}
      />

      <ViewWithPopup
        className={
          Object.keys('showing').length !== null &&
          showing.setStartDate !== null
            ? 'activated'
            : ''
        }
        key={400}
        noView={true}
        view={<Button type="default">종료된 전시</Button>}
      />

      <div className="view_with__popup">
        <div className="popup_handler">
          <Button type="default" onClick={ onSearchReset }>
            Reset
          </Button>
        </div>
      </div>
    </CategroySearchWrapper>
  );
};

export default CategotySearch;
